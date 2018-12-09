package pl.mlewando.jug.flashtalk.java_js_communication.swing_demo_app;

import java.awt.BorderLayout;
import java.time.format.DateTimeFormatter;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import io.reactivex.functions.Consumer;

class PagePanel extends JPanel implements Consumer<ApplicationState> {

    private static final long serialVersionUID = 1L;

    private final JLabel text;

    PagePanel() {
        setLayout(new BorderLayout());

        text = new JLabel("No Data");
        text.setHorizontalAlignment(SwingConstants.CENTER);
        text.setVerticalAlignment(SwingConstants.CENTER);

        add(text, BorderLayout.CENTER);
    }

    @Override
    public void accept(ApplicationState t) throws Exception {
        text.setText(t.getTime().format(DateTimeFormatter.ofPattern("HH:mm:ss")) + " - " + t.getText());
    }

}
