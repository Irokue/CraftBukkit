package net.minecraft.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet133Money extends Packet {
	
	public double money;
	public int playerId;

	public Packet133Money(){}
	public Packet133Money(int playerId, int money){
		this.playerId = playerId;
		this.money = money;
	}
	
	@Override
	public void a(DataInputStream datainputstream) throws IOException {
		// TODO Auto-generated method stub
		this.playerId = datainputstream.readInt();
		this.money = datainputstream.readDouble();
	}
	@Override
	public void a(DataOutputStream dataoutputstream) throws IOException {
		// TODO Auto-generated method stub
		dataoutputstream.writeInt(playerId);
		dataoutputstream.writeDouble(money);
	}
	@Override
	public void handle(NetHandler nethandler) {
		// TODO Auto-generated method stub
		nethandler.a(this);
		
	}
	@Override
	public int a() {
		// TODO Auto-generated method stub
		return (int) (12 * this.money);
	}

}
