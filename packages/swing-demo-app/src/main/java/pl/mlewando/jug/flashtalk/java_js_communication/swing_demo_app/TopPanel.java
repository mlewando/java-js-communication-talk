
package pl.mlewando.jug.flashtalk.java_js_communication.swing_demo_app;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.function.Consumer;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

class TopPanel extends JPanel {

    private static final long serialVersionUID = 1L;

    private final JTextField textField;
    private final Consumer<String> onChange;

    TopPanel(Consumer<String> onChange) {
        this.textField = new JTextField("some data");
        this.onChange = onChange;

        var okButton = new JButton("OK");
        okButton.addActionListener(a -> changed());

        setLayout(new GridBagLayout());
        setBorder(BorderFactory.createEmptyBorder(5, 20, 5, 10));
        var layoutConstraint = new GridBagConstraints();
        layoutConstraint.gridx = 0;
        layoutConstraint.gridy = 0;
        layoutConstraint.fill = GridBagConstraints.HORIZONTAL;
        layoutConstraint.weightx = 1;
        add(textField, layoutConstraint);
        layoutConstraint.weightx = 0;
        layoutConstraint.gridx = 1;
        layoutConstraint.fill = GridBagConstraints.NONE;
        var buttonWrapper = new JPanel();
        buttonWrapper.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 0));
        buttonWrapper.add(okButton);
        add(buttonWrapper, layoutConstraint);
    }

    private void changed() {
        onChange.accept(textField.getText());
    }

    void setState(String text) {
        textField.setText(text);
    }
}
