package edu.uclm.esi.games.ws;

import org.springframework.web.socket.WebSocketSession;

import edu.uclm.esi.games.model.AbstractPlayer;

public class WSSession {
	private WebSocketSession session;
	private AbstractPlayer player;
	private String uuid;

	public WSSession(WebSocketSession session, AbstractPlayer player, String uuid) {
		this.session=session;
		this.player=player;
		this.uuid=uuid;
	}

	public WebSocketSession getSession() {
		return this.session;
	}
	
	public String getId() {
		return this.session.getId();
	}

	public void setPlayer(AbstractPlayer player) {
		this.player=player;
	}

	public AbstractPlayer getPlayer() {
		return this.player;
	}

	public String getUuid() {
		return uuid;
	}

}