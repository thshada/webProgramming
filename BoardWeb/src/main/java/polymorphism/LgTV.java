package polymorphism;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("tv")
public class LgTV implements TV {
	
	@Autowired
	private Speaker speaker;
	
	public void turnOn() {
		System.out.println("LgTV---전원 켠다");
	}
	public void turnOff() {
		System.out.println("LgTV---전원 끈다.");
	}
	public void soundUp() {
		System.out.println("LgTV---소리 올린다.");
	}
	public void soundDown() {
		System.out.println("LgTV---소리 내린다.");
	}
	@Override
	public void powerOn() {
		System.out.println("LgTV ---전원켠다");
	}
	@Override
	public void powerOff() {
		System.out.println("LgTV---전원끈다.");
	}
	@Override
	public void volumeUp() {
		speaker.volumeUp();
	}
	@Override
	public void volumeDown() {
		speaker.volumeDown();
	}
}
