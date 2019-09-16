package exceptions;

import java.io.PrintStream;
import java.io.PrintWriter;

public class NotBorrowedException extends Exception {

	@Override
	public String getMessage() {
		// TODO 自动生成的方法存根
		return super.getMessage();
	}

	@Override
	public String getLocalizedMessage() {
		// TODO 自动生成的方法存根
		return super.getLocalizedMessage();
	}

	@Override
	public synchronized Throwable getCause() {
		// TODO 自动生成的方法存根
		return super.getCause();
	}

	@Override
	public synchronized Throwable initCause(Throwable cause) {
		// TODO 自动生成的方法存根
		return super.initCause(cause);
	}

	@Override
	public String toString() {
		// TODO 自动生成的方法存根
		return super.toString();
	}

	@Override
	public void printStackTrace() {
		// TODO 自动生成的方法存根
		super.printStackTrace();
	}

	@Override
	public void printStackTrace(PrintStream s) {
		// TODO 自动生成的方法存根
		super.printStackTrace(s);
	}

	@Override
	public void printStackTrace(PrintWriter s) {
		// TODO 自动生成的方法存根
		super.printStackTrace(s);
	}

	@Override
	public synchronized Throwable fillInStackTrace() {
		// TODO 自动生成的方法存根
		return super.fillInStackTrace();
	}

	@Override
	public StackTraceElement[] getStackTrace() {
		// TODO 自动生成的方法存根
		return super.getStackTrace();
	}

	@Override
	public void setStackTrace(StackTraceElement[] stackTrace) {
		// TODO 自动生成的方法存根
		super.setStackTrace(stackTrace);
	}

}
