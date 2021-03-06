/**
 *  ControlAsistencias
 *
 *  Copyright 2017 Sergio Rodenas
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
    name: "ControlAsistencias",
    namespace: "Rodenastyle",
    author: "Sergio Rodenas",
    description: "Practica entregable Smart things",
    category: "My Apps",
    iconUrl: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience.png",
    iconX2Url: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience@2x.png",
    iconX3Url: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience@2x.png")


preferences {
	page(
    	name: "pageDevicePreferences",
        title: "Dispositivos",
        nextPage: "pageCommunicationPreferences",
        install: false,
        unistall: true
    ){
    	section([hideable: true, hidden: true], "Dispositivos de presencia"){
        	input "presenceSensor", "capability.presenceSensor", title: "Seleccione dispositivos"
        }
    }
    
    page(
    	name: "pageCommunicationPreferences",
        title: "Preferencias de comunicacion",
        install: true,
        unistall: true
    ){
    	section([hideable: true, hidden: true], "Configurar modo"){
        	input "motionSensors", "enum", title: "Seleccione el modo en el que se mandaran notificaciones", options: ["home", "work", "away"]
        }
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

// TODO: implement event handlers