package com.mirea.prac2;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class CommonMain {

    public static void main(final String[] args) throws AlreadyBoundException, RemoteException, InterruptedException, NotBoundException {
        String[] client = new String[] {"client.cfg"};
        String[] server = new String[] {"server.cfg"};

        Thread serverThread = new Thread(() -> {
            try {
                ServerMain.main(server);
                Thread.sleep(1000);
            } catch (RemoteException | AlreadyBoundException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread clientThread = new Thread(() -> {
            try {
                ClientMain.main(client);
            } catch (RemoteException | NotBoundException e) {
                throw new RuntimeException(e);
            }
        });

        serverThread.start();
        clientThread.start();


    }
}
