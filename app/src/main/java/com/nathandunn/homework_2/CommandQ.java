package com.nathandunn.homework_2;

import com.nathandunn.homework_2.commands.Command;

import java.util.Stack;

public class CommandQ {
    private static CommandQ commandQInstance;
    private static Stack<Command> undoStack;
    private static Stack<Command> redoStack;

    private CommandQ (){
        undoStack = new Stack<>();
        redoStack = new Stack<>();
    }

    public static CommandQ getInstance(){
        if(commandQInstance == null)
            commandQInstance = new CommandQ();

        return commandQInstance;
    }

    public void executeCommand(Command command){
        command.doIt();
        undoStack.push(command);
        redoStack.clear();
    }

    public void undoCommand(){
        if(!undoStack.empty()) {
            Command command = undoStack.pop();
            command.undoIt();
            redoStack.push(command);
        }
    }

    public void redoCommand(){
        if(!redoStack.empty()) {
            Command command = redoStack.pop();
            command.doIt();
            undoStack.push(command);
        }
    }

    public int getUndoStackSize(){
        return undoStack.size();
    }

    public int getRedoStackSize(){
        return redoStack.size();
    }

}
