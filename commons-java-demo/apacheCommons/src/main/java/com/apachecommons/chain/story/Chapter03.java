package com.apachecommons.chain.story;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;

import com.commons.utils.IOUtils;

/**
 * 第三章
 * 
 * @author liuxl
 * 2017-10-11 下午6:28:56
 */
public class Chapter03 implements Command {

    @Override
    public boolean execute(Context context) throws Exception {
        IOUtils.delayPrint("第三章: " + StoryContext.STORY_CONTENT.get("ch03").get(context.get("route")), 300);
        IOUtils.delayPrint("剧终, 本故事纯属虚构...\n", 300);
        return false;
    }

}
