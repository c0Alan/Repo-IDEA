package com.demo.java.apachecommons;

import org.apache.commons.chain.Context;
import org.apache.commons.chain.impl.ChainBase;
import org.apache.log4j.Logger;

import com.chain.story.Chapter01;
import com.chain.story.Chapter02;
import com.chain.story.Chapter03;
import com.chain.story.StoryChain;
import com.chain.story.StoryContext;

/**
 * apache commons chain 包测试类
 * 
 * @author liuxl
 * 2017-9-30 下午1:21:35
 */
public class ChainDemo {
    
    private static Logger logger = Logger.getLogger(ChainDemo.class);
    
    public void test(){
        logger.info("story finished.");
    }
    
    public static void beginStory(){
        ChainBase story = new StoryChain(); 
        story.addCommand(new Chapter01());
        story.addCommand(new Chapter02());
        story.addCommand(new Chapter03());
        Context ctx = new StoryContext();  
        try {
            story.execute(ctx);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    public static void main(String[] args) throws Exception {
        beginStory();
    }
}
