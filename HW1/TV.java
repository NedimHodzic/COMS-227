package hw1;

/**
 * 
 * @author Nedim Hodzic
 * Model of a TV with the ability to change volume, channels, the number of channels, and the start channel.
 */

public class TV {
	public static final double VOLUME_INCREMENT = 0.07;
	/**
	 * The number of channels for the TV.
	 */
	private int numChannels;
	/**
	 * The volume of the TV.
	 */
	private double volume;
	/**
	 * The current channel the TV is on.
	 */
	private int currentChannel;
	/**
	 * The start channel for the TV.
	 */
	private int start;
	/**
	 * The channel that was on the TV previously.
	 */
	private int prevChannel;
	
	/**
	 * Constructs a TV with a given start channel and a given number of Channels. It also initializes the current channel to the start channel, volume to 0.5, and the previous channel to the start channel.
	 * @param givenStart
	 * 	The start channel for the TV
	 * @param givenNumChannels
	 * 	Number of channels the TV has
	 */
	public TV(int givenStart, int givenNumChannels) {
		start = givenStart;
		currentChannel = givenStart;
		numChannels = givenNumChannels;
		volume = 0.5;
		prevChannel = givenStart;
	}
	
	/**
	 * Sets the previous channel to the current channel then lowers the channel by 1, wrapping back to the highest channel once it reaches 0.
	 */
	public void channelDown() {
		prevChannel = currentChannel;
		currentChannel -= start;
		currentChannel = ((currentChannel - 1 + numChannels) % numChannels) + start;
	}
	
	/**
	 * Sets the previous channel to the current channel then raises the channel by 1, wrapping back to the start channel once it reaches the highest channel.
	 */
	public void channelUp() {
		prevChannel = currentChannel;
		currentChannel -= start;
		currentChannel = ((currentChannel + 1) % numChannels) + start;
	}
	
	/**
	 * Displays the current channel and the volume as a percent.
	 * @return
	 * 	Channel number and volume in a string
	 */
	public String display() {
		double volumeRounded = Math.round(volume * 100);
		int percent = (int)(volumeRounded);
		String display;
		display = "Channel " + currentChannel + " Volume " + percent + "%";
		return display;
	}
	
	/**
	 * Returns the current channel.
	 * @return
	 * 	current channel the TV is on
	 */
	public int getChannel() {
		return currentChannel;
	}
	
	/**
	 * Returns the current volume.
	 * @return
	 * 	current volume the TV is on
	 */
	public double getVolume() {
		return volume;
	}
	
	/**
	 * Sets the current channel to the previous channel.
	 */
	public void goToPreviousChannel() {
		currentChannel = prevChannel;
	}
	
	/**
	 * Resets the start channel with the given start channel.
	 * @param givenStart
	 * 	the new start channel
	 */
	public void resetStart(int givenStart) {
		start = givenStart;
		currentChannel = Math.max(start, Math.min(currentChannel, start + numChannels - 1));
		prevChannel = givenStart;
	}
	
	/**
	 * Resets the number of channels the TV has given a number of channels.
	 * @param givenNumChannels
	 * 	the new amount of channels
	 */
	public void resetNumChannels(int givenNumChannels) {
		numChannels = givenNumChannels;
		currentChannel = Math.max(start, Math.min(currentChannel, start + numChannels - 1));
		prevChannel = currentChannel;
	}
	
	/**
	 * Sets the current channel to the given channel number
	 * @param channelNumber
	 * 	the new channel number
	 */
	public void setChannel(int channelNumber) {
		prevChannel = currentChannel;
		currentChannel = Math.max(start, Math.min(channelNumber, start + numChannels - 1));
	}
	
	/**
	 * Reduces the volume of the TV
	 */
	public void volumeDown() {
		volume -= VOLUME_INCREMENT;
		volume = Math.max(volume, 0);
	}
	
	/**
	 * Increases the volume of the TV
	 */
	public void volumeUp() {
		volume += VOLUME_INCREMENT;
		volume = Math.min(volume, 1);
	}
}