#include<iostream>
#include<string>

using namespace std;

class Transportation {
	private:

	public:
};


class SeaTransport : public Transportation {
	private:

	public:
};


class LandTransport : public Transportation {
	private:

	public:
};


class AirTransport : public Transportation {
	private:

	public:
};


class Car : public LandTransport {
	private:

	public:
};


class Canoe : public SeaTransport {
	private:

	public:
};


class HoverCraft : public SeaTransport, public LandTransport {
	private:

	public:
};


int main(){

}