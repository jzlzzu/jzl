package com.jzl.poi;

import com.jzl.utils.ExcelUtil;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

/**
 * @Author: jzl
 * @Description:
 * @Date: Created in 10:18 2019/3/15
 * @Modified By:
 */
public class TestFileUpAndDownLoad {

    @Test
    public void testFileUpload() throws IOException, InvalidFormatException {
        String filePath = "C:\\Users\\admin\\Desktop\\jzl临时文件夹\\file_task_collect_data.xls";
        ExcelUtil excelUtil = new ExcelUtil();
        Workbook workbook = excelUtil.chooseWorkbook(filePath, new FileInputStream(new File(filePath)));
        List<List<String>> lists = excelUtil.readDate(workbook);
        System.out.println(lists);
    }
}
