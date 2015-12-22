package com.vedic.astro.chain;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
 
public class PingCommand implements Command {
 
	private String message;
 
	public PingCommand( String message ) {
		this.message = message;
	}
 
	public boolean execute( Context context ) throws Exception {
 
		System.err.println( message );
		System.out.println( "ping ...." + context.get("NAME") );
		return false;
	}
}