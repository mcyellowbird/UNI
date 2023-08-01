import json
import googlemaps
import random

serviceType = ["Electrical", "Plumbing", "Carpentry", "Landscaping", "Painting"]
emailDomains = ["gmail.com", "hotmail.com", "outlook.com"]

tradieProfiles = {"tradies":[]}
clientProfiles = {"clients":[]}
serviceRequests = {"services":[]}
taskDescriptions = {"electrical":[],"plumbing":[],"carpentry":[],"landscaping":[],"painting":[]}

with open('config.json') as f:
    config = json.load(f)

googlemaps_api_key = config['googlemaps_api_key']
gmaps = googlemaps.Client(key=googlemaps_api_key)

def generateTradies():
    tradieNames = ["Eliana Peters", "Patrick Bates", "Madilyn Castaneda", "Collin Rodgers", "Selah Juarez", "Joaquin Mason", "Sienna Powers", "Sean Curry", "Alison Zuniga", "Sincere Arellano", "Faye Galvan", "Kingsley Bender", "Lilyana Castaneda", "Collin Gomez", "Natalie Huerta", "Douglas Yoder", "Emerie Lugo", "Santos Macias", "Adley Sawyer", "Jefferson Vasquez"]

    phonenums = [f"04{random.randint(10000000, 99999999)}" for _ in range(50)]

    for i in range(20):
        # Generate random address

        southWest = [-34.437578, 150.842202]
        northEast = [-34.414922, 150.900957]
        lngSpan = northEast[1] - southWest[1]
        latSpan = northEast[0] - southWest[0]

        randLat = southWest[0] + latSpan * random.random()
        randLong = southWest[1] + lngSpan * random.random()

        reverse_geocode_result = gmaps.reverse_geocode((randLat, randLong))

        newTradie = {}

        newTradie["tradieID"] = f"t{i+1:02}" # Zero-padded numeric ID with 2 digits
        emails = []
        for name in tradieNames:
            firstName, lastName = name.split(" ")
            email = f"{firstName.lower()}.{lastName.lower()}@{random.choice(emailDomains)}"
            emails.append(email)
        
        firstName, lastName = tradieNames[i].split(' ')
        newTradie["firstName"] = firstName
        newTradie["lastName"] = lastName
        newTradie["phoneNumber"] = phonenums[i]
        newTradie["email"] = emails[i]
        newTradie["type"] = random.choice(serviceType)
        # newTradie["address"] = random.randint(100, 100000)
        newTradie["address"] = reverse_geocode_result[0]["formatted_address"]
        newTradie["activeJobs"] = []
        newTradie["completedJobs"] = []
        newTradie["password"] = firstName + lastName
        newTradie["membership"] = False
        newTradie["wallet"] = 1000
        
        # Append the newTradie dictionary to the tradieProfiles list
        tradieProfiles["tradies"].append(newTradie)

    # Add service requests to random tradies
    
    for i in range(len(serviceRequests)):
        # randomClient = random.randrange(clientCount)
        randomTradie = random.randint(0,len(tradieProfiles["tradies"])-1)
        tradieProfiles["tradies"][randomTradie]["activeJobs"].append(serviceRequests["services"][i])

    with open("tradieProfiles.json", "w") as f:
        json.dump(tradieProfiles, f, indent=4) # Indent with 4 spaces

def generateClients():
    clientNames = ["Maggie Hamilton", "Molly Wright", "Oscar James", "Isabella Moore", "Matilda King", "Theodore Campbell", "Freya Smith", "Nate Hernandez", "Niamh Allen", "Georgia White", "Zachary Davis", "Lola Evans", "Aiden Scott", "Isla Taylor", "Aria Brown", "Lincoln Wilson", "Lily Green", "Caleb Clarke", "Violet Mitchell", "Elijah Baker",    "Hazel Lee", "Jaxon Lewis", "Charlotte Turner", "Felix Hall", "Lucy Campbell",    "Levi Young", "Sophie Phillips", "Oliver Ross", "Eva Martin", "Mason Bell",    "Ivy Anderson", "Cooper Parker", "Harper Morris", "Ryder Kelly", "Nora Roberts",    "Jackson Cook", "Ruby Nelson", "Harrison Wright", "Scarlett Cox", "Hunter Parker",    "Alice Reed", "Ethan Bailey", "Zara Collins", "Dylan Cooper", "Sadie Hughes",    "Max Wood", "Chloe Gray", "Wyatt Adams", "Ella Jenkins", "Liam Richardson"]

    phonenums = [f"04{random.randint(10000000, 99999999)}" for _ in range(50)]

    for i in range(50):
        # Generate random address

        southWest = [-34.437578, 150.842202]
        northEast = [-34.414922, 150.900957]
        lngSpan = northEast[1] - southWest[1]
        latSpan = northEast[0] - southWest[0]

        randLat = southWest[0] + latSpan * random.random()
        randLong = southWest[1] + lngSpan * random.random()

        reverse_geocode_result = gmaps.reverse_geocode((randLat, randLong))

        newClient = {}

        # Generate emails for each client name
        emails = []
        for name in clientNames:
            firstName, lastName = name.split(" ")
            email = f"{firstName.lower()}.{lastName.lower()}@{random.choice(emailDomains)}"
            emails.append(email)
        
        newClient["clientID"] = f"c{i+1:02}" # Zero-padded numeric ID with 2 digits
        firstName, lastName = clientNames[i].split(' ')
        newClient["firstName"] = firstName
        newClient["lastName"] = lastName
        newClient["phoneNumber"] = phonenums[i]
        newClient["email"] = emails[i]
        # newClient["address"] = random.randint(100, 100000)
        newClient["address"] = reverse_geocode_result[0]["formatted_address"]
        newClient["activeJobs"] = []
        newClient["completedJobs"] = []
        newClient["password"] = firstName + lastName
        newClient["membership"] = False
        newClient["wallet"] = 1000
        
        clientID = f"c{i+1:02}" # Zero-padded numeric ID with 2 digits
        
        # Append the newClient dictionary to the clientProfiles list
        clientProfiles["clients"].append(newClient)
        
    # Add service requests to random clients
    for i in range(len(serviceRequests["services"])):
        # randomClient = random.randrange(clientCount)
        randomClient = random.randint(0,len(clientProfiles["clients"])-1)
        clientProfiles["clients"][randomClient]["activeJobs"].append(serviceRequests["services"][i])
        serviceRequests["services"][i]["address"] = clientProfiles["clients"][randomClient]["address"]

    with open("clientProfiles.json", "w") as f:
        json.dump(clientProfiles, f, indent=4) # Indent with 4 spaces
        
    with open("serviceRequests.json", "w") as f:
        json.dump(serviceRequests, f, indent=4) # Indent with 4 spaces

def generateServiceRequests():

    tasks = [["Switch and Socket", "Appliances", "Wiring", "MCB & Fuse", "Door Bell"],
        ["Leakages", "Bath Fittings", "Toilet", "Water Tank", "Basin & Sink"],
        ["Bed", "Cupboard & Drawer", "Door", "Furniture Repair", "Window & Curtain"],
        ["Lawn Mowing", "Weeding", "Hedge Trimming", "Pruning", "Landscape Design"],
        ["Wall Painting", "Exterior Painting", "Ceiling Painting", "Trim Painting", "Fence Painting"]]

    for i in range(100):
        # Generate random address

        southWest = [-34.437578, 150.842202]
        northEast = [-34.414922, 150.900957]
        lngSpan = northEast[1] - southWest[1]
        latSpan = northEast[0] - southWest[0]

        randLat = southWest[0] + latSpan * random.random()
        randLong = southWest[1] + lngSpan * random.random()

        # reverse_geocode_result = gmaps.reverse_geocode((randLat, randLong))

        newRequest = {}
        
        newRequest["requestID"] = f"r{i+1:02}" # Zero-padded numeric ID with 2 digits
        newServiceType = random.choice(serviceType)
        newRequest["serviceType"] = newServiceType
        # newRequest["service-description"] = random.choice(serviceDescriptions)

        # Adding task descriptions to each service request
        taskDesc = 0

        if random.random() < 0.8:  # 80% of the time
            jobCost = round(random.uniform(40, 1000), 2)  # generate cost between $40.00 and $1000.00
        else:  # 20% of the time
            jobCost = round(random.uniform(1000, 5000), 2)  # generate cost between $1000.00 and $5000.00

        if newServiceType == "Electrical":
            taskDesc = random.choice(tasks[0])
            # Checking if the random task description is not already in the list of task descriptions
            if not any(d.get("name") == taskDesc for d in taskDescriptions["electrical"]):
                taskDescriptions["electrical"].append({"name": taskDesc, "price": jobCost})
        elif newServiceType == "Plumbing":
            taskDesc = random.choice(tasks[1])
            if not any(d.get("name") == taskDesc for d in taskDescriptions["plumbing"]):
                taskDescriptions["plumbing"].append({"name": taskDesc, "price": jobCost})
        elif newServiceType == "Carpentry":
            taskDesc = random.choice(tasks[2])
            if not any(d.get("name") == taskDesc for d in taskDescriptions["carpentry"]):
                taskDescriptions["carpentry"].append({"name": taskDesc, "price": jobCost})
        elif newServiceType == "Landscaping":
            taskDesc = random.choice(tasks[3])
            if not any(d.get("name") == taskDesc for d in taskDescriptions["landscaping"]):
                taskDescriptions["landscaping"].append({"name": taskDesc, "price": jobCost})
        elif newServiceType == "Painting":
            taskDesc = random.choice(tasks[4])
            if not any(d.get("name") == taskDesc for d in taskDescriptions["painting"]):
                taskDescriptions["painting"].append({"name": taskDesc, "price": jobCost})

        newRequest["jobDescription"] = taskDesc
        newRequest["address"] = "temporary address"
        # newRequest["address"] = reverse_geocode_result[0]["formatted_address"]

        if random.random() < 0.8:  # 80% of the time
            cost = round(random.uniform(40, 1000), 2)  # generate cost between $40.00 and $1000.00
        else:  # 20% of the time
            cost = round(random.uniform(1000, 5000), 2)  # generate cost between $1000.00 and $5000.00
            
        newRequest["quotedCost"] = f"${cost:.2f}"
        
        # Append the newRequest dictionary to the serviceRequests list
        serviceRequests["services"].append(newRequest)

    with open("serviceRequests.json", "w") as f:
        json.dump(serviceRequests, f, indent=4) # Indent with 4 spaces

    with open("serviceTypes.json", "w") as f:
        json.dump(taskDescriptions, f, indent=4) # Indent with 4 spaces

generateServiceRequests()
generateClients()
generateTradies()