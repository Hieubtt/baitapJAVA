package thucHanh;

import org.springframework.web.servlet.view.InternalResourceViewResolver;

public class Vd1 {

	public static void main(String[] args) {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		viewResolver.setViewClass(org.springframework.web.servlet.view.JstlView.class);
	}

}
