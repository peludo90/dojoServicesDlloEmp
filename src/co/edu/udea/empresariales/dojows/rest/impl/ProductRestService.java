package co.edu.udea.empresariales.dojows.rest.impl;

import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import co.edu.udea.empresariales.dojows.dao.ProductDAO;
import co.edu.udea.empresariales.dojows.model.Product;
import co.edu.udea.empresariales.dojows.model.Store;
import co.edu.udea.empresariales.dojows.rest.IProductRestWebService;

@Path(value="/product")
@WebService(endpointInterface="co.edu.udea.empresariales.dojows.rest.IProductRestWebService")
public class ProductRestService implements IProductRestWebService{

	private ProductDAO productDao;
	
	public ProductRestService() {
		// TODO Auto-generated constructor stub
		productDao = new ProductDAO();
	}
	
	@GET
	@Path(value="/store/{fullName}")
	@Produces(value ={MediaType.APPLICATION_JSON})
	@Override
	public List<Store> findStore(@PathParam(value="fullName")String fullName) {
		// TODO Auto-generated method stub
		return productDao.findStore(fullName);
	}

	@GET
	@Produces(value ={MediaType.APPLICATION_JSON})
	@Override
	public Product find(@QueryParam(value="fullName")String fullName) {
		// TODO Auto-generated method stub
		return productDao.find(fullName);
	}

}
