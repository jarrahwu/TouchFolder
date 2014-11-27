package com.android.util.plugin.mifolder;

import com.android.util.plugin.Processor;
import com.android.util.plugin.Provider;


public class DumpProvider implements Provider {

	private static final Processor PROCESSOR = new DumpProcessor();

	@Override
	public Processor getProcessor() {
		return PROCESSOR;
	}

}
