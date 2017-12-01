/**
 *  LucesSinState
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
    name: "LucesSinState",
    namespace: "Rodenastyle",
    author: "Sergio Rodenas",
    description: "Entregable LucesSinState",
    category: "My Apps",
    iconUrl: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience.png",
    iconX2Url: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience@2x.png",
    iconX3Url: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience@2x.png")


preferences {
	section("Home bulbs") {
		input "lights", "capability.switch", multiple: true
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
	subscribe lights, "switch.on", greenPowerLightsDaemon
}

def greenPowerLightsDaemon(evt){
	log.debug "Checking lights"
	runIn(5, greenPowerLightsCheck)
}

def greenPowerLightsCheck(){
	lights
    	.clone() //Do not edit default sensors
    	.findAll{
        	//Check whether bulbs are on
            it.currentValue("switch") == "on"
        }
        .sort{
        	//Order them by last state change (to on)
            it.currentState("switch").getDate()
        }
        .reverse() //Reverse the order to put the last bulb in the first place and do not remove it later
        .drop(1) //Delete last updated light (this also dodges app turn off an only one light)
        .each{
       	 	//Delete rest of bulbs
        	it.off()
        }
}