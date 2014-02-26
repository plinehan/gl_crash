package com.plinehan.crash;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {
	private CrashView _crashView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		_crashView = new CrashView(this);
		setContentView(_crashView);

		new Invalidator(_crashView).run();
	}

	static class Invalidator implements Runnable {
		private final View _view;

		public Invalidator(View view) {
			_view = view;
		}

		@Override
		public void run() {
			_view.invalidate();
			_view.postDelayed(new Invalidator(_view), 100);
		}
	}
}
