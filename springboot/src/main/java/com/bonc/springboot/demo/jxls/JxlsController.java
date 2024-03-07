package com.bonc.springboot.demo.jxls;


import com.bonc.springboot.demo.jxls.entity.ApprovalBO;
import org.apache.commons.jexl3.JexlBuilder;
import org.apache.commons.jexl3.JexlEngine;
import org.jxls.common.Context;
import org.jxls.expression.JexlExpressionEvaluator;
import org.jxls.transform.Transformer;
import org.jxls.transform.poi.PoiTransformer;
import org.jxls.util.JxlsHelper;
import org.jxls.util.Util;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JxlsController {

    // https://jxls.sourceforge.net/reference/poi_transformer.html
    public static void main(String[] args) {
        System.out.println("Hello World!");
        test2();
    }

    // 高版本批注导出格式
    public static void test() {
        try {
            // 读取模板
            InputStream is = JxlsController.class.getClassLoader().getResourceAsStream("jxlsTemplate/1.xls");
            // 要输出的文件目录
            String tempFilaPath = "/Users/mac/c/1.xls";
            // 输出流
            OutputStream os = new BufferedOutputStream(new FileOutputStream(tempFilaPath));
            //ByteArrayOutputStream os = new ByteArrayOutputStream();
            // 定义数据  使用Context类型
            Context context = new Context();
            // 图片信息
            InputStream imageInputSteam = JxlsController.class.getClassLoader().getResourceAsStream("jxlsTemplate/a.png");
            byte[] byteArray = Util.toByteArray(imageInputSteam);

            context.putVar("personCID", "111");
            context.putVar("name", "222");
            context.putVar("jobName", "挖掘机");
            context.putVar("imageInfo", byteArray);

            List<ApprovalBO> approvalBOList = new ArrayList<>();
            ApprovalBO approvalBO1 = new ApprovalBO();
            ApprovalBO approvalBO2 = new ApprovalBO();
            ApprovalBO approvalBO3 = new ApprovalBO();

            approvalBO1.setName("张哈哈");
            approvalBO1.setEmail("123@456");
            approvalBO1.setTime("2099-10-32 18:00");
            approvalBO1.setOptition("同意");

            approvalBO2.setName("张笑笑");
            approvalBO2.setEmail("123@456");
            approvalBO2.setTime("2099-10-32 19:00");
            approvalBO2.setOptition("不同意");

            approvalBO3.setName("张哭哭");
            approvalBO3.setEmail("123@456");
            approvalBO3.setTime("2099-10-32 20:00");
            approvalBO3.setOptition("再考虑");

            approvalBOList.add(approvalBO1);
            approvalBOList.add(approvalBO2);
            approvalBOList.add(approvalBO3);
            context.putVar("approvalBOList", approvalBOList);

            // 数据写入模板
            JxlsHelper jxlsHelper = JxlsHelper.getInstance();
            Transformer transformer = jxlsHelper.createTransformer(is, os);
            JexlExpressionEvaluator evaluator = (JexlExpressionEvaluator) transformer.getTransformationConfig().getExpressionEvaluator();

            // 添加自定义函数
            Map<String, Object> funcs = new HashMap<>();
            funcs.put("utils", new JxlsController());
            JexlEngine jexl = new JexlBuilder().namespaces(funcs).create();
            evaluator.setJexlEngine(jexl);
            jxlsHelper.setUseFastFormulaProcessor(false).processTemplate(context, transformer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 旧版本标签模式测试，不生效 jxls版本太高
    public static void test2() {
        try {
            // 读取模板
            InputStream is = JxlsController.class.getClassLoader().getResourceAsStream("jxlsTemplate/4.xlsx");
            // 要输出的文件目录
            String tempFilaPath = "/Users/mac/c/1.xls";
            // 输出流
            OutputStream os = new BufferedOutputStream(new FileOutputStream(tempFilaPath));

            // 定义数据  使用Context类型
            Context context = new Context();
            // 图片信息
            InputStream imageInputSteam = JxlsController.class.getClassLoader().getResourceAsStream("jxlsTemplate/a.png");
            byte[] byteArray = Util.toByteArray(imageInputSteam);

            context.putVar("imageInfo", byteArray);

            List<ApprovalBO> approvalBOList = new ArrayList<>();
            ApprovalBO approvalBO1 = new ApprovalBO();
            ApprovalBO approvalBO2 = new ApprovalBO();
            ApprovalBO approvalBO3 = new ApprovalBO();

            approvalBO1.setName("张哈哈");
            approvalBO1.setEmail("123@456");
            approvalBO1.setTime("2099-10-32 18:00");
            approvalBO1.setOptition("同意");

            approvalBO2.setName("张笑笑");
            approvalBO2.setEmail("123@456");
            approvalBO2.setTime("2099-10-32 19:00");
            approvalBO2.setOptition("不同意");

            approvalBO3.setName("张哭哭");
            approvalBO3.setEmail("123@456");
            approvalBO3.setTime("2099-10-32 20:00");
            approvalBO3.setOptition("再考虑");

            approvalBOList.add(approvalBO1);
            approvalBOList.add(approvalBO2);
            approvalBOList.add(approvalBO3);
            context.putVar("data", approvalBOList);

            // 数据写入模板
            JxlsHelper jxlsHelper = JxlsHelper.getInstance();
            // PoiTransformer transformer = PoiTransformer.createTransformer(is, os);
            Transformer transformer = jxlsHelper.createTransformer(is, os);
            JexlExpressionEvaluator evaluator = (JexlExpressionEvaluator) transformer.getTransformationConfig().getExpressionEvaluator();

            // 添加自定义函数
            Map<String, Object> funcs = new HashMap<>();
            funcs.put("utils", new JxlsController());
            JexlEngine jexl = new JexlBuilder().namespaces(funcs).create();
            evaluator.setJexlEngine(jexl);
            jxlsHelper.setUseFastFormulaProcessor(false).processTemplate(context, transformer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
