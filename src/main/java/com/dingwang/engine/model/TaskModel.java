/* Copyright 2013-2015 www.snakerflow.com.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.dingwang.engine.model;

/**
 * 任务定义task元素
 * 
 * @author yuqs
 * @since 1.0
 */
public class TaskModel extends NodeModel {
    /**
     * 
     */
    private static final long  serialVersionUID = 1775545243233990922L;
    /**
     * 类型：普通任务
     */
    public static final String PERFORMTYPE_ANY  = "ANY";
    /**
     * 类型：参与者fork任务
     */
    public static final String PERFORMTYPE_ALL  = "ALL";
    /**
     * 类型：主办任务
     */
    public static final String TASKTYPE_MAJOR   = "Major";
    /**
     * 类型：协办任务
     */
    public static final String TASKTYPE_AIDANT  = "Aidant";

    /**
     * 参与类型
     */
    public enum PerformType {
        ANY,
        ALL;
    }

    /**
     * 任务类型(Major:主办的,Aidant:协助的,Record:仅仅作为记录的)
     */
    public enum TaskType {
        Major,
        Aidant,
        Record;
    }

    /**
     * 参与者变量名称
     */
    private String assignee;
    /**
     * 参与方式 any：任何一个参与者处理完即执行下一步 all：所有参与者都完成，才可执行下一步
     */
    private String performType = PERFORMTYPE_ANY;
    /**
     * 任务类型 major：主办任务 aidant：协办任务
     */
    private String taskType    = TASKTYPE_MAJOR;
    /**
     * 期望完成时间
     */
    private String expireTime;
    /**
     * 提醒时间
     */
    private String reminderTime;
    /**
     * 提醒间隔(分钟)
     */
    private String reminderRepeat;
    /**
     * 是否自动执行
     */
    private String autoExecute;
    /**
     * 任务执行后回调类
     */
    private String callback;
    /**
     * 分配参与者处理类型
     */
    private String assignmentHandler;

    public boolean isPerformAny() {
        return PERFORMTYPE_ANY.equalsIgnoreCase(this.performType);
    }

    public boolean isPerformAll() {
        return PERFORMTYPE_ALL.equalsIgnoreCase(this.performType);
    }

    public boolean isMajor() {
        return TASKTYPE_MAJOR.equalsIgnoreCase(this.taskType);
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(String expireTime) {
        this.expireTime = expireTime;
    }

    public String getTaskType() {
        return taskType;
    }

    public String getReminderTime() {
        return reminderTime;
    }

    public void setReminderTime(String reminderTime) {
        this.reminderTime = reminderTime;
    }

    public String getReminderRepeat() {
        return reminderRepeat;
    }

    public void setReminderRepeat(String reminderRepeat) {
        this.reminderRepeat = reminderRepeat;
    }

    public String getAutoExecute() {
        return autoExecute;
    }

    public void setAutoExecute(String autoExecute) {
        this.autoExecute = autoExecute;
    }

    public String getAssignmentHandler() {
        return assignmentHandler;
    }

    public String getCallback() {
        return callback;
    }

    /*
     * (non-Javadoc)
     * @see com.dingwang.engine.Action#execute()
     */
    @Override
    public void execute() {
        // TODO Auto-generated method stub

    }

}
