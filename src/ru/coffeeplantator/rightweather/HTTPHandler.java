package ru.coffeeplantator.rightweather;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.text.ParseException;

// Назначение класса: получение ответа от http-сервера. Основное применение: конструктор с адресом -> makeRequest().

public class HTTPHandler {

	private String URL;
	private String encoding;
	private String header;
	private Socket socket;
	private StringBuilder response;
	
	//Конструктор
	public HTTPHandler(String URL, String encoding) {
		this.URL = URL;
		this.encoding = encoding;
		this.response = null;
		this.header = null;
		this.socket = null;
	}
	
	//
	public StringBuilder makeRequest() {
		try {
			this.header = makeHeader(URL);
			this.socket = makeConnection(header);
			response = sendRequest(socket, header);
			return response;
		}
		catch (Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
			return null;
		}
		finally {
			try {
				if (socket != null) {
					socket.close();
				}
			} catch (IOException e) {
				System.err.println("Ошибка при закрытии сокета");
				e.printStackTrace();
			}
		}	
	}
	
	// Подготовка HTTP-заголовка
	private String makeHeader(String URL) {
		String header = null;
		header = "GET " + URL + " HTTP/1.1\n" + "Host: " + getSubString(URL, "http://", "/", 0) + "\n"
				+ "Accept: image/gif, image/x-xbitmap, image/jpeg, image/pjpeg, */*\n" + "Referer: http://localhost/\n"
				+ "Accept-Language: ru\n" + "NetSurf/0.2 (KolibriOS)\n" + "Proxy-Connection: Keep-Alive\n\n";
		return header;
	}
	
	// Ищет первую подстроку, обрамлённую указанными строками.
	private String getSubString(String rawString, String start, String end, int position) {
		int i = rawString.indexOf(start, position);
		int j = rawString.indexOf(end, i + start.length());
		return rawString.substring(i + start.length(), j);
	}
	
	private Socket makeConnection(String header) throws Exception {
		// Из HTTP заголовка берется адрес сервера
		String host = null;
		int port = 0;
		try {
			host = getHost(header);
			port = getPort(host);
			host = getHostWithoutPort(host);
		} catch (Exception e) {
			throw new Exception("Не удалось получить адрес сервера." + e.getMessage(), e);
		}
		// Отправляется запрос на сервер
		Socket socket = null;
		try {
			socket = new Socket(host, port);
//			System.out.println("Создан сокет: " + host + " port:" + port);
		} catch (Exception e) {
			socket.close();
			throw new Exception("Ошибка при создании соединения: " + e.getMessage(), e);
		}
		return socket;
	}
	
	private StringBuilder sendRequest(Socket socket, String header) throws Exception {
		try {
			socket.getOutputStream().write(header.getBytes());
//			System.out.println("Заголовок отправлен. \n");
		} catch (Exception e) {
			throw new Exception("Ошибка при отправке запроса: " + e.getMessage(), e);
		}
		// Ответ от сервера записывается в результирующую строку
		try {
			BufferedInputStream input = new BufferedInputStream(socket.getInputStream());
			InputStreamReader inputReader = new InputStreamReader(input, encoding);
			final int bufferSize = 256 * 1024;
			final char[] buffer = new char[bufferSize];
			final StringBuilder out = new StringBuilder();
			for (; ; ) {
		        int readSize = inputReader.read(buffer, 0, buffer.length);
		        if (readSize < 0)
		             break;
		        out.append(buffer, 0, readSize);
		    }
			return out;
		} catch (Exception e) {
			throw new Exception("Ошибка при чтении ответа от сервера." + e.getMessage(), e);
		}
	}
	
	// Возвращает имя хоста (при наличии порта, с портом) из HTTP заголовка
	private String getHost(String header) throws ParseException {
		final String host = "Host: ";
		final String normalEnd = "\n";
		final String msEnd = "\r\n";

		int s = header.indexOf(host, 0);
		if (s < 0) {
			return "localhost";
		}
		s += host.length();
		int e = header.indexOf(normalEnd, s);
		e = (e > 0) ? e : header.indexOf(msEnd, s);
		if (e < 0) {
			throw new ParseException("В заголовке запроса не найдено " + "закрывающих символов после пункта Host.", 0);
		}
		String res = header.substring(s, e).trim();
		return res;
	}

	// Возвращает номер порта
	private int getPort(String hostWithPort) {
		int port = hostWithPort.indexOf(":", 0);
		port = (port < 0) ? 80 : Integer.parseInt(hostWithPort.substring(port + 1));
		return port;
	}

	// Возвращает имя хоста без порта
	private String getHostWithoutPort(String hostWithPort) {
		int portPosition = hostWithPort.indexOf(":", 0);
		if (portPosition < 0) {
			return hostWithPort;
		} else {
			return hostWithPort.substring(0, portPosition);
		}
	}
	
	// Сеттеры
	public void setURL(String URL) {
		this.URL = URL;
	}
	
	//Геттеры
	public StringBuilder getResponse() {
		return response;
	}
	
	public String getURL() {
		return URL;
	}
	
	public String getHeader() {
		return header;
	}

}
