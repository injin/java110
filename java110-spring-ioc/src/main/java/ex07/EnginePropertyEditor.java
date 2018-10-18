package ex07;

import java.beans.PropertyEditorSupport;

public class EnginePropertyEditor extends PropertyEditorSupport {
    
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        
        String[] splits = text.split(",");
        if (splits.length < 3) {
            throw new IllegalArgumentException("매개변수 개수 부족");
        }
        
        String maker = splits[0];
        int value = Integer.parseInt(splits[1]);
        boolean isDisel = Boolean.parseBoolean(splits[2]);
        
        this.setValue(new Engine(maker, value, isDisel));
    }
    
}
