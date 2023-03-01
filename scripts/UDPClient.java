<!DOCTYPE html>
<html>
<head>
    <!DOCTYPE html>
<html lang="en">
<head>
  <title>Portfolio Website-Marcus</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="style.css">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.1.3/js/bootstrap.bundle.min.js" integrity="sha512-i7r9zLu8afJLHdZwJjKscFLF+JGzrb7msHvK97zQgC9bm+anbrvux8Wn48nMHovJb3a4ft6lLPL4Ioyxz6XzUg==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
  <script src="https://kit.fontawesome.com/31149d48b0.js" crossorigin="anonymous"></script>
</head>
    <header>
        <nav class="navbar navbar-expand-lg fixed-top navbarScroll">
            <div class="container">
                <a class="navbar-brand" href="#">Marcus</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav ms-auto">
                        <li class="nav-item active">
                            <a class="nav-link" href="#home">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#about">About</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#services">Services</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#portfolio">Portfolio</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#contact">Contact</a>
                        </li>
                    </ul>
                    
                </div>
            </div>
        </nav>
    </header>
    <body>
        <!-- navbar -->
        <nav class="navbar navbar-expand-lg fixed-top navbar-dark navbarScroll">
            <div class="container">
                <a class="navbar-brand" href="#">Marcus</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav ms-auto">
                        <li class="nav-item active">
                            <a class="nav-link" href="#home">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#about">About</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#services">Services</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#portfolio">Portfolio</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#contact">Contact</a>
                        </li>
                    </ul>
                    
                </div>
            </div>
        </nav>
    
        <!-- UDP Download Files -->
        <section id="portfolio">
            <div class="container mt-3">
                <h1 class="text-center">UDP Server & Client Programs:</h1>
                <div class="row">
                    <div class="col-lg-4 mt-4">
                        <div class="card">
                            <img class="card-img-top" src="images/portfolioImage1.jpg" alt="Card image" style="width:100%">
                                
                            <div class="card-body">
                                <h4 class="card-title">UPD Client & Server</h4>
                                <p class="card-text">Two Java programs that requests to send a lower case sentence adn it will return the same sentence in uppercase letters.</p>
                        
                                    <div class="container">

                                        <div class="row">
                                          <div class="col-md-5 mx-auto">
                                            <div class="input-group">
                                              <span>
                                                <a href="scripts/UDPServer.java" download><i class="fas fa-file-code fa-2x text-center"><br>Server&nbsp;</i></a>
                                                <a href="scripts/UDPClient.java" download><i class="fas fa-file-code fa-2x text-center"><br>&nbsp;Client</i></a> 
                                              </span>
                                            </div>
                                          </div>
                                        </div>
                                      </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="container mt-5">
                        <pre><code>/*
Java server with UDP socket to accept client's request to change its message to
all upper case characters

C:\....> javac UDPServer.java
C:\....> java UDPServer
*/

import java.io.*;
import java.net.*;

public class UDPServer {
public static void main(String args[]) {
    DatagramSocket serverSocket = null;

    try {
        // 1. creating a server socket, parameter is local port number 12009
        serverSocket = new DatagramSocket(12000);

        // buffer to receive incoming data
        byte[] buffer = new byte[65536];
        DatagramPacket incoming = new DatagramPacket(buffer, buffer.length);

        // 2. Wait for an incoming data
        System.out.println("\nThe server is ready to receive......");

        // communication loop
        while (true) {
            serverSocket.receive(incoming);
            byte[] data = incoming.getData();
            String sentence = new String(data, 0, incoming.getLength());
            DatagramPacket dp = new DatagramPacket(sentence.toUpperCase().getBytes(),
                    sentence.toUpperCase().getBytes().length,
                    incoming.getAddress(), incoming.getPort());
            serverSocket.send(dp);
        }
    }

    catch (IOException e) {
        System.err.println("IOException " + e);
    }
}
}</code></pre>
                      </div>

                    </div>
                    <div class="container mt-5">
<pre><code>/*
    Java client with UDP socket to request server to change message to
    all upper case characters
    
    C:\....> javac UDPClient.java
    C:\....> java UDPClient
*/
import java.io.*;
import java.net.*;

public class UDPClient {
    public static void main(String args[]) {
        DatagramSocket clientSocket = null;
        int port = 12000; // in case port 12000 is already used by another server
        String sentence;
        BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));

        try {
            clientSocket = new DatagramSocket();
            InetAddress host = InetAddress.getByName("localhost");

            while (true) {
                // get input and send the packet
                System.out.println("\nInput lowercase sentence:\n");
                sentence = (String) cin.readLine();
                byte[] b = sentence.getBytes();
                DatagramPacket dp = new DatagramPacket(b, b.length, host, port);
                clientSocket.send(dp);

                // now receive reply
                byte[] buffer = new byte[65536];
                DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
                clientSocket.receive(reply);
                byte[] data = reply.getData();
                sentence = new String(data, 0, reply.getLength());
                System.out.println(sentence);
            }
        } catch (IOException e) {
            System.err.println("IOException " + e);
        }
    }
}</code></pre>
                      </div>

                    </div>    
                    
    
                
                
        </section>
    
        <!-- contact section-->
        <section id="contact">
            <div class="container mt-3 contactContent">
                <h1 class="text-center">Contact Me</h1>
    
                <div class="row mt-4">
                    <div class="col-lg-6">
                        <div style="max-width:100%;overflow:hidden;color:red;width:500px;height:500px;">
                            <div id="embedmap-canvas" style="height:100%; width:100%;max-width:100%;">
                                <iframe style="height:100%;width:100%;border:0;" frameborder="0" src="https://www.google.com/maps/embed/v1/place?q=tampa&key=AIzaSyBFw0Qbyq9zTFTd-tUY6dZWTgaQzuU17R8">
                                </iframe>
                            
                            </div>
                            <a class="googlemaps-html" href="https://www.embed-map.com" id="get-data-forembedmap">https://www.embed-map.com</a>
                            <style>#embedmap-canvas img{max-width:none!important;background:none!important;font-size: inherit;font-weight:inherit;}
                            </style>
                        </div>
                    </div>
                 <div class="col-lg-6">
                    <!-- form fields -->
                    <form>
                        <input type="text" class="form-control form-control-lg" placeholder="Name">
                        <input type="email" class="form-control mt-3" placeholder="Email">
                        <div class="mb-3 mt-3">
                        </div>
                        <button type="button" class="btn btn-success mt-3">Contact Me</button>  
                </div>
            </div>
        </section>
        <!-- footer section-->
        <footer id="footer">
            <div class="container-fluid">
                <p>Marcus Maley<br>
                <a href="mailto:marcus_maley@verizon.net">marcus_maley@verizon.net</a></p>
            </div>
        </footer>
    
        <!-- load javascript after loading all html content -->
        <script src="script.js"></script>
    
    </body>
