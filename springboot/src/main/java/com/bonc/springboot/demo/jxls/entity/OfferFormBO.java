package com.bonc.springboot.demo.jxls.entity;

import lombok.Data;

import java.util.List;

@Data
public class OfferFormBO {

    /**
     * 应聘者ID
     */
    private String personCID;
    /**
     * 录用人员
     */
    private String name;
    /**
     * 应聘职位
     */
    private String jobName;
    /**
     * 审批信息
     */
    List<ApprovalBO> approvalBOList;
}
