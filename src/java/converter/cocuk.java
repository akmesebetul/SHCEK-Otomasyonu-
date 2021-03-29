/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import dao.cocukDao;
import entity.Cocuk;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Casper
 */
@FacesConverter(value="cocuk")
public class cocuk implements Converter{
    private cocukDao cocukDao;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
    return this.getCocukDao().find(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
        Cocuk c=(Cocuk) arg2;
        return c.getId_cocuk().toString();
    }

    public cocukDao getCocukDao() {
        if(this.cocukDao==null){
           this.cocukDao=new cocukDao(); 
        }
        return cocukDao;
    }
    
}
