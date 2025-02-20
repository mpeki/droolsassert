package org.droolsassert.jbehave;

import static java.lang.reflect.Proxy.newProxyInstance;
import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import org.droolsassert.DroolsSession;

public class DroolsSessionProxy implements InvocationHandler {
	
	public static DroolsSession newDroolsSessionProxy(DroolsSessionProxy invocationHandler) {
		return (DroolsSession) newProxyInstance(DroolsSessionProxy.class.getClassLoader(),
				new Class[] { DroolsSession.class },
				invocationHandler);
	}
	
	String[] resources = new String[0];
	String[] source = new String[0];
	String[] sessionProperties = new String[0];
	String[] sessionPropertySource = new String[0];
	String[] baseProperties = new String[0];
	String[] basePropertySource = new String[0];
	String[] builderProperties = new String[0];
	String[] builderPropertySource = new String[0];
	String[] ignoreRules = new String[0];
	String ignoreRulesSource = EMPTY;
	boolean logResources;
	boolean keepFactsHistory = true;
	boolean logFacts = true;
	boolean log = true;
	boolean showStateTransitionPopup = false;
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		switch (method.getName()) {
		case "value":
		case "resources":
			return resources;
		case "source":
			return source;
		case "sessionProperties":
			return sessionProperties;
		case "sessionPropertySource":
			return sessionPropertySource;
		case "baseProperties":
			return baseProperties;
		case "basePropertySource":
			return basePropertySource;
		case "builderProperties":
			return builderProperties;
		case "builderPropertySource":
			return builderPropertySource;
		case "ignoreRules":
			return ignoreRules;
		case "ignoreRulesSource":
			return ignoreRulesSource;
		case "logResources":
			return logResources;
		case "keepFactsHistory":
			return keepFactsHistory;
		case "logFacts":
			return logFacts;
		case "log":
			return log;
		case "showStateTransitionPopup":
			return showStateTransitionPopup;
		case "hashCode":
			return hashCode();
		case "equals":
			return equals(args[0]);
		default:
			throw new IllegalAccessError(method.getName());
		}
	}
	
	@Override
	public int hashCode() {
		return reflectionHashCode(this, false);
	}
	
	@Override
	public boolean equals(Object obj) {
		return reflectionEquals(this, obj, false);
	}
}
