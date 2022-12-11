package InterfazGrafica;

import javax.swing.text.DocumentFilter;
import javax.swing.text.NumberFormatter;

private class NumberFormatterFilter extends DocumentFilter {

    private NumberFormatter formatter;

    public NumberFormatterFilter(NumberFormatter formatter) {
      this.formatter = formatter;
    }

    @Override
    public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr)
        throws BadLocationException {
      super.insertString(fb, offset, string, attr);
      format(fb, offset, string.length());
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
        throws BadLocationException {
      super.replace(fb, offset, length, text, attrs);
      format(fb, offset, text.length());
    }

    private void format(FilterBypass fb, int offset, int length) throws BadLocationException {
      Document doc = fb.getDocument();
      String text = doc.getText(0, doc.getLength());
      try {
        formatter.stringToValue(text);
      } catch (ParseException e) {
        return;
      }
      super.remove(fb, 0, doc.getLength());
      super.insertString(fb, 0, text, null);
    }
  }