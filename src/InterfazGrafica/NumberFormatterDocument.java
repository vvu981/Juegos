package InterfazGrafica;

import javax.swing.text.AbstractDocument;
import javax.swing.text.DocumentFilter;
import javax.swing.text.Element;
import javax.swing.text.NumberFormatter;

public class NumberFormatterDocument extends AbstractDocument {

  private NumberFormatter formatter;

  public NumberFormatterDocument(NumberFormatter formatter) {
	  super(null);
    this.formatter = formatter;
  }

  protected NumberFormatterFilter createDocumentFilter() {
    return new NumberFormatterFilter(formatter);
  }

@Override
public Element getDefaultRootElement() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public Element getParagraphElement(int pos) {
	// TODO Auto-generated method stub
	return null;
}

  
}
