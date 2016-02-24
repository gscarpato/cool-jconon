package it.cnr.jconon.rest;

import it.cnr.cool.cmis.service.CMISService;
import it.cnr.jconon.service.application.ApplicationService;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Path("application")
@Component
@Produces(MediaType.APPLICATION_JSON)
public class Application {
	private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);
	private static final String SEARCH_CONTENT = "/search/content?nodeRef=";
	@Autowired
	private CMISService cmisService;
	@Autowired
    private ApplicationService applicationService;

	/**
	 * Esclusione
	 * @param req
	 * @param nodeRef
	 * @return
	 * @throws IOException
	 */
	@POST
	@Path("reject")
	public Map<String, Object> reject(@Context HttpServletRequest req,
			@FormParam("nodeRef") String nodeRef) throws IOException{
		LOGGER.debug("Reject application:" + nodeRef);

		applicationService.reject(cmisService.getCurrentCMISSession(req),
				nodeRef);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("nodeRef", nodeRef);
		return model;
	}
	/**
	 * Rinuncia
	 * @param req
	 * @param nodeRef
	 * @return
	 * @throws IOException
	 */
	@POST
	@Path("waiver")
	public Map<String, Object> waiver(@Context HttpServletRequest req,
			@FormParam("nodeRef") String nodeRef) throws IOException{
		LOGGER.debug("Reject application:" + nodeRef);

		applicationService.waiver(cmisService.getCurrentCMISSession(req),
				nodeRef);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("nodeRef", nodeRef);
		return model;
	}
	/**
	 * Riammissione
	 * @param req
	 * @param nodeRef
	 * @return
	 * @throws IOException
	 */
	@POST
	@Path("readmission")
	public Map<String, Object> readmission(@Context HttpServletRequest req,
			@FormParam("nodeRef") String nodeRef) throws IOException{
		LOGGER.debug("Reject application:" + nodeRef);

		applicationService.readmission(cmisService.getCurrentCMISSession(req),
				nodeRef);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("nodeRef", nodeRef);
		return model;
	}

	/**
	 * addContentToChild
	 * @param req
	 * @param nodeRef
	 * @return
	 * @throws IOException
	 */
	@GET
	@Path("addContentToChild")
	public Map<String, Object> addContentToChild(@Context HttpServletRequest req,
			@QueryParam("nodeRef") String nodeRef) throws IOException{
		LOGGER.debug("Reject application:" + nodeRef);

		applicationService.addContentToChild(cmisService.getCurrentCMISSession(req),
				nodeRef, req.getLocale(), getContextURL(req));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("nodeRef", nodeRef);
		return model;
	}	

	@GET
	@Path("exportSchedeValutazione")
	public Map<String, Object> exportSchedeValutazione(@Context HttpServletRequest req,
			@QueryParam("id") String id, @QueryParam("format") String format) throws IOException{
		LOGGER.debug("Export Schede Valutazione:" + id);
		String nodeRef = applicationService.exportSchedeValutazione(cmisService.getCurrentCMISSession(req),
				id, format, cmisService.getCMISUserFromSession(req));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("url", SEARCH_CONTENT + nodeRef + "&deleteAfterDownload=true");
		model.put("nodeRef", nodeRef);		
		return model;
	}	

	@GET
	@Path("generaSchedeValutazione")
	public Map<String, Object> generaSchedeValutazione(@Context HttpServletRequest req,
			@QueryParam("id") String id, @QueryParam("email") String email) throws IOException{
		LOGGER.debug("Genera Schede Valutazione:" + id);
		applicationService.generaSchedeValutazione(cmisService.getCurrentCMISSession(req),
				id, req.getLocale(), getContextURL(req), cmisService.getCMISUserFromSession(req), email);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("status", true);
		return model;
	}	

	@GET
	@Path("generaSchedeAnonime")
	public Map<String, Object> generaSchedeAnonime(@Context HttpServletRequest req,
			@QueryParam("id") String id, @QueryParam("email") String email) throws IOException{
		LOGGER.debug("Genera Schede Anonime Sintetiche:" + id);
		applicationService.generaSchedeAnonime(cmisService.getCurrentCMISSession(req),
				id, req.getLocale(), getContextURL(req), cmisService.getCMISUserFromSession(req), email);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("status", true);
		return model;
	}	
	
	public String getContextURL(HttpServletRequest req) {
		return req.getScheme() + "://" + req.getServerName() + ":"
				+ req.getServerPort() + req.getContextPath();
	}
	
}