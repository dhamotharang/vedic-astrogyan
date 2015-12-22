package com.vedic.astro.chain;

import org.apache.commons.chain.Context;
import org.apache.commons.chain.impl.ChainBase;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
 
public class ChainRunner implements BeanFactoryAware {
 
	private BeanFactory beanFactory;
 
	public void runChain( String chainName, Context context ) {
		try {
			createChain ( chainName ).execute( context );
		}
		catch ( Exception exc ) {
			throw new RuntimeException(
					"Chain \"" + chainName + "\": Execution failed.", exc );
		}
	}
 
	public void setBeanFactory( BeanFactory beanFactory ) throws BeansException {
		this.beanFactory = beanFactory;
	}
 
	protected ChainBase createChain( String chainName ) {
		return ( ChainBase ) this.beanFactory.getBean( chainName );
	}
}
