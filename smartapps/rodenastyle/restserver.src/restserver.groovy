/**
 *  RestServer
 *
 *  Copyright 2017 Sergio R&oacute;denas
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License. You may obtain a copy of the License at:
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
 *  on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License
 *  for the specific language governing permissions and limitations under the License.
 *
 */
definition(
    name: "RestServer",
    namespace: "Rodenastyle",
    author: "Sergio Rodenas",
    description: "RestServer",
    category: "My Apps",
    iconUrl: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience.png",
    iconX2Url: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience@2x.png",
    iconX3Url: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience@2x.png")


preferences {
	section("Title") {
		//input "interruptores", "capability.switch", multiple: true
      	//input "temperaturas", "capability.temperatureMeasurement", multiple: true
        //input "presencia", "capability.presenceSensor", multiple: true
        //input "electricos", "capability.voltageMeasurement", multiple: true
        //input "luminosidad", "capability.illuminanceMeasurement", multiple: true
        //input "humedad", "capability.relativeHumidityMeasurement", multiple: true
	}
}

mappings{
	path("/info"){
    	action: [
        	GET: "getDevicesInfo"
        ]
    }
}

def installed() {
	log.debug "Installed with settings: ${settings}"

	initialize()
}

def updated() {
	log.debug "Updated with settings: ${settings}"

	unsubscribe()
	initialize()
}

def initialize() {
	// TODO: subscribe to attributes, devices, locations, etc.
}

def getDevicesInfo(){
	return [
    	general: [
        	themperature: new Random().nextInt(60) + 1,
            humity: new Random().nextInt(90) + 1,
            occupancy: new Random().nextInt(10) + 1,
            electric: new Random().nextInt(30) + 1,
            heating: new Random().nextInt(30) + 1,
            brightness: new Random().nextInt(400) + 1
        ],
        
        outside: [
        	themperature: new Random().nextInt(60) + 1,
            humity: new Random().nextInt(90) + 1,
            occupancy: new Random().nextInt(10) + 1,
            electric: new Random().nextInt(30) + 1,
            heating: new Random().nextInt(30) + 1,
            brightness: new Random().nextInt(400) + 1
        ],
        
        room1: [
        	themperature: new Random().nextInt(60) + 1,
            humity: new Random().nextInt(90) + 1,
            occupancy: new Random().nextInt(10) + 1,
            electric: new Random().nextInt(30) + 1,
            heating: new Random().nextInt(30) + 1,
            brightness: new Random().nextInt(400) + 1
        ],
        
        room2: [
        	themperature: new Random().nextInt(60) + 1,
            humity: new Random().nextInt(90) + 1,
            occupancy: new Random().nextInt(10) + 1,
            electric: new Random().nextInt(30) + 1,
            heating: new Random().nextInt(30) + 1,
            brightness: new Random().nextInt(400) + 1
        ],
        
        room3: [
        	themperature: new Random().nextInt(60) + 1,
            humity: new Random().nextInt(90) + 1,
            occupancy: new Random().nextInt(10) + 1,
            electric: new Random().nextInt(30) + 1,
            heating: new Random().nextInt(30) + 1,
            brightness: new Random().nextInt(400) + 1
        ],
        
        room4: [
        	themperature: new Random().nextInt(60) + 1,
            humity: new Random().nextInt(90) + 1,
            occupancy: new Random().nextInt(10) + 1,
            electric: new Random().nextInt(30) + 1,
            heating: new Random().nextInt(30) + 1,
            brightness: new Random().nextInt(400) + 1
        ],
        
        kitchen: [
        	themperature: new Random().nextInt(60) + 1,
            humity: new Random().nextInt(90) + 1,
            occupancy: new Random().nextInt(10) + 1,
            electric: new Random().nextInt(30) + 1,
            heating: new Random().nextInt(30) + 1,
            brightness: new Random().nextInt(400) + 1
        ],
        
        livingroom: [
        	themperature: new Random().nextInt(60) + 1,
            humity: new Random().nextInt(90) + 1,
            occupancy: new Random().nextInt(10) + 1,
            electric: new Random().nextInt(30) + 1,
            heating: new Random().nextInt(30) + 1,
            brightness: new Random().nextInt(400) + 1
        ],
        
        bathroom1: [
        	themperature: new Random().nextInt(60) + 1,
            humity: new Random().nextInt(90) + 1,
            occupancy: new Random().nextInt(10) + 1,
            electric: new Random().nextInt(30) + 1,
            heating: new Random().nextInt(30) + 1,
            brightness: new Random().nextInt(400) + 1
        ],
        
        bathroom2: [
        	themperature: new Random().nextInt(60) + 1,
            humity: new Random().nextInt(90) + 1,
            occupancy: new Random().nextInt(10) + 1,
            electric: new Random().nextInt(30) + 1,
            heating: new Random().nextInt(30) + 1,
            brightness: new Random().nextInt(400) + 1
        ]
    ]
}