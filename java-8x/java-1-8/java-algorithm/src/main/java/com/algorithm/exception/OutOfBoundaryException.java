package com.algorithm.exception;

/**
 * 线性表中出现序号越界时抛出该异常
 * 
 * @author liuxilin
 * @date 2018/5/28 21:00
 */
public class OutOfBoundaryException extends RuntimeException{
	
	public OutOfBoundaryException(String err){
		super(err);
	}
}
