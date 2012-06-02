package net.minecraft.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet134Job extends Packet {

	public Packet134Job(){}
	public Packet134Job(int playerId, String job, int jobLevel, int jobExperience, int jobMaxExperience){
		this.playerId = playerId;
		this.job = job;
		this.jobExperience = jobExperience;
		this.jobMaxExperience = jobMaxExperience;
		this.jobLevel = jobLevel;
	}
	
	@Override
	public void a(DataInputStream datainputstream) throws IOException {
		this.playerId = datainputstream.readInt();
		this.job = a(datainputstream, 20);
		this.jobLevel = datainputstream.readInt();
		this.jobExperience = datainputstream.readInt();
		this.jobMaxExperience = datainputstream.readInt();
	}

	@Override
	public void a(DataOutputStream dataoutputstream) throws IOException {
		dataoutputstream.writeInt(playerId);
		if(this.job == null) this.job = "Aucun";
		a(this.job, dataoutputstream);
		dataoutputstream.writeInt(jobLevel);
		dataoutputstream.writeInt(jobExperience);
		dataoutputstream.writeInt(jobMaxExperience);
	}

	@Override
	public void handle(NetHandler nethandler) {
		nethandler.a(this);
	}

	@Override
	public int a() {
		// TODO Auto-generated method stub
		return 12;
	}
	
	public int jobLevel;
	public int jobExperience;
	public int jobMaxExperience;
	public String job = "";
	public int playerId;
}
