package au.usyd.elec5619.web;

import java.util.Map;

import javax.servlet.http.HttpSession;

import junit.framework.TestCase;

import org.springframework.web.servlet.ModelAndView;

import au.usyd.elec5619.service.ComparisonDAO;
import au.usyd.elec5619.service.ComparisonServiceLayer;

public class RetailerControllerTest extends TestCase
{
	public void testHandleRequestView() throws Exception{
		
		WishlistComparisonController controller= new WishlistComparisonController();
		controller.setComparisonServiceLayer(new ComparisonServiceLayer());
		controller.setComparisonDAO(new ComparisonDAO());
		Object session = null; // = new HttpSession();
		((HttpSession) session).setAttribute("user","kp2@gmail.com");
		ModelAndView modelAndView = controller.handleRequest_new_again(null, null, (HttpSession) session);
		
		assertEquals("NotLogged", modelAndView.getViewName());
		assertNotNull(modelAndView.getModel());
		Map modelMap= (Map) modelAndView.getModel().get("model");
		
		
	}
}