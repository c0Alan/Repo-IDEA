package com.apachecommons.chain.story;

import java.util.Scanner;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;

import com.commons.utils.IOUtils;

/**
 * 第二章
 * 
 * @author liuxl
 * 2017-10-11 下午6:28:43
 */
public class Chapter02 implements Command {

    @SuppressWarnings("unchecked")
    @Override
    public boolean execute(Context context) throws Exception {
        IOUtils.delayPrint("第二章: " + StoryContext.STORY_CONTENT.get("ch02").get(context.get("route")), 300);
        IOUtils.delayPrint("请选择下章剧情: 1,2,3\n", 300);
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        context.put("route", Integer.valueOf(i).toString());
        IOUtils.delayPrint("即将进入下一章...\n", 300);
        return false;
    }

}
