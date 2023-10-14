from scapy.all import *

a=rdpcap("/home/kali/Desktop/lab2.pcap")

for packet in a:
	t = packet.show(dump=True) #dump – determine if it prints or returns the string value
	if t.find("password") != -1:
		hexdump(packet)
		print("=============================")
		print(packet)
		print("=============================")
		print(t)