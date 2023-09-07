package com.bonc.springboot.demo.jxls.entity;

import lombok.Data;

@Data
public class ApprovalBO
{
        /**
         * 审批人姓名
         */
        private String name;
        /**
         * 审批人邮箱
         */
        private String email;
        /**
         * 审批时间
         */
        private String time;
        /**
         * 审批意见
         */
        private String optition;
}
