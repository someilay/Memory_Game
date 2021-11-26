package main.java.middleware;

import main.java.Button;

/** The Command interface */
public interface ButtonClick {
    public Response execute(Button button);
}
