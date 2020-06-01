package com.jzl.jzlspring;

import com.jzl.entity.Tree;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Author: jzl
 * @Description:
 * @Date: Created in 9:55 2020/5/26
 * @Modified By:
 */
public class MyImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        System.out.println("MyImportSelector");
        // 返回一个类全名
        return new String[]{Tree.class.getName()};
    }
}
