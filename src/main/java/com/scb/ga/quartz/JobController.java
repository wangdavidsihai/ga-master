package com.scb.ga.quartz;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.scb.ga.domain.JobAndTrigger;
import com.scb.ga.interfaces.facade.dto.CustomJob;
import com.scb.ga.service.JobAndTriggerService;

/**
 * @author David Wang
 *
 */
@Controller
@RequestMapping(value = "/quartz")
public class JobController {
	@Autowired
	private JobAndTriggerService jobAndTriggerService;

	// 加入Qulifier注解，通过名称注入bean
	@Autowired
	@Qualifier("Scheduler")
	private Scheduler scheduler;

	private static Logger log = LoggerFactory.getLogger(JobController.class);

	@PostMapping(value = "/add")
	public String add(CustomJob job) throws Exception {
		if (StringUtils.isEmpty(job.getCronExp()) || StringUtils.isEmpty(job.getJobClassName())
				|| StringUtils.isEmpty(job.getJobGroupName())) {
			return "quartz/list";
		}
		addJob(job.getJobClassName(), job.getJobGroupName(), job.getCronExp());
		return "quartz/list";
	}

	public void addJob(String jobClassName, String jobGroupName, String cronExpression) throws Exception {

		// 启动调度器
		scheduler.start();

		// 构建job信息
		JobDetail jobDetail = JobBuilder.newJob(getClass(jobClassName).getClass())
				.withIdentity(jobClassName, jobGroupName).build();

		// 表达式调度构建器(即任务执行的时间)
		CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression);

		// 按新的cronExpression表达式构建一个新的trigger
		CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(jobClassName, jobGroupName)
				.withSchedule(scheduleBuilder).build();

		try {
			scheduler.scheduleJob(jobDetail, trigger);

		} catch (SchedulerException e) {
			System.out.println("创建定时任务失败" + e);
			throw new Exception("创建定时任务失败");
		}
	}

	@PostMapping(value = "/pausejob")
	public void pausejob(@RequestParam(value = "jobClassName") String jobClassName,
			@RequestParam(value = "jobGroupName") String jobGroupName) throws Exception {
		jobPause(jobClassName, jobGroupName);
	}

	public void jobPause(String jobClassName, String jobGroupName) throws Exception {
		scheduler.pauseJob(JobKey.jobKey(jobClassName, jobGroupName));
	}

	@PostMapping(value = "/resumejob")
	public void resume(@RequestParam(value = "jobClassName") String jobClassName,
			@RequestParam(value = "jobGroupName") String jobGroupName) throws Exception {
		jobResume(jobClassName, jobGroupName);
	}

	public void jobResume(String jobClassName, String jobGroupName) throws Exception {
		scheduler.resumeJob(JobKey.jobKey(jobClassName, jobGroupName));
	}

	@PostMapping(value = "/reschedule")
	public void reschedule(@RequestParam(value = "jobClassName") String jobClassName,
			@RequestParam(value = "jobGroupName") String jobGroupName,
			@RequestParam(value = "cronExpression") String cronExpression) throws Exception {
		jobReschedule(jobClassName, jobGroupName, cronExpression);
	}

	public void jobReschedule(String jobClassName, String jobGroupName, String cronExpression) throws Exception {
		try {
			TriggerKey triggerKey = TriggerKey.triggerKey(jobClassName, jobGroupName);
			// 表达式调度构建器
			CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression);

			CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);

			// 按新的cronExpression表达式重新构建trigger
			trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();

			// 按新的trigger重新设置job执行
			scheduler.rescheduleJob(triggerKey, trigger);
		} catch (SchedulerException e) {
			System.out.println("更新定时任务失败" + e);
			throw new Exception("更新定时任务失败");
		}
	}

	@PostMapping(value = "/delete")
	public void delete(@RequestParam(value = "jobClassName") String jobClassName,
			@RequestParam(value = "jobGroupName") String jobGroupName) throws Exception {
		deleteJob(jobClassName, jobGroupName);
	}

	public void deleteJob(String jobClassName, String jobGroupName) throws Exception {
		scheduler.pauseTrigger(TriggerKey.triggerKey(jobClassName, jobGroupName));
		scheduler.unscheduleJob(TriggerKey.triggerKey(jobClassName, jobGroupName));
		scheduler.deleteJob(JobKey.jobKey(jobClassName, jobGroupName));
	}

	@RequestMapping(value = "/list")
	public String list(Model model) {
		List<JobAndTrigger> jobAndTrigger = jobAndTriggerService.getJobAndTriggerDetails();
		model.addAttribute("list", jobAndTrigger);
		return "quartz/list";
	}

	public static Job getClass(String classname) throws Exception {
		Class<?> class1 = Class.forName(classname);
		return (Job) class1.newInstance();
	}

	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String toform(@RequestParam(value = "id", required = false) String id, Model model) {
		String url = null;
		if (StringUtils.isNotBlank(id)) {
			// model.addAttribute("menu", menuService.get(id));
			url = "/menu/" + id + "/modify";
		} else {
			url = "/quartz/add";
			if (StringUtils.isNotBlank(id)) {
				model.addAttribute("parentPath", id);
			}
		}
		model.addAttribute("api", url);
		return "quartz/form";
	}

}
