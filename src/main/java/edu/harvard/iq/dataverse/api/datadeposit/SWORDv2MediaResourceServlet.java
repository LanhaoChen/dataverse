package edu.harvard.iq.dataverse.api.datadeposit;

import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.swordapp.server.MediaResourceAPI;
import org.swordapp.server.servlets.SwordServlet;

public class SWORDv2MediaResourceServlet extends SwordServlet {

    @Inject
    MediaResourceManagerImpl mediaResourceManagerImpl;
    /**
     * @todo Should we inject this in all the SWORDv2 Servlets? Added here so
     * that we can inject SettingsServiceBean in SwordConfigurationImpl.
     */
    @Inject
    SwordConfigurationImpl swordConfigurationImpl;

    protected MediaResourceAPI api;

    @Override
    public void init() throws ServletException {
        super.init();

        // load the api
        this.api = new MediaResourceAPI(mediaResourceManagerImpl, swordConfigurationImpl);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.api.get(req, resp);
    }

    @Override
    protected void doHead(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.api.head(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.api.post(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.api.put(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.api.delete(req, resp);
    }
}
