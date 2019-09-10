package am.chronograph.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;

import org.omnifaces.converter.SelectItemsConverter;

import am.chronograph.domain.group.Group;

@FacesConverter("exampleEntitySelectItemsConverter")
public class ExampleEntitySelectItemsConverter extends SelectItemsConverter {
	
	@Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Long id = (value instanceof Group) ? ((Group) value).getId() : null;
        return (id != null) ? String.valueOf(id) : null;
    }

}
