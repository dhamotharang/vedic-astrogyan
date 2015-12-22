package com.vedic.astro.chain;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
 
public class PongCommand implements Command {
 
	private String message;
 
	public PongCommand( String message ) {
		this.message = message;
	}
 
	public boolean execute( Context context ) throws Exception {
 
		System.err.println( message );
		System.out.println("pong ...." + context.get("NAME") );
		return false;
	}
}