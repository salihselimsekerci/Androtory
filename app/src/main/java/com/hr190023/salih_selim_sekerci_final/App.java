package com.hr190023.salih_selim_sekerci_final;

import android.app.Application;

public class App extends Application {
    App app = null;

    public App getApp() {
        if (app == null) {
            app = this;
        }
        return app;
    }
}
