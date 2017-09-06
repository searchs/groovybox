def s = 'this is a string ${1+1}'
println s

println "Another interpolation is here: ${1+1}"

Range r = 1..101
println r[-3]
println r.from

def nums = [1,2,3,4,5,6,7,,8,9,10]
//nums.each { println it }
nums.each { n -> println n }


nums.eachWithIndex {n, idx -> 
println "nums[$idx] == $n}"
}

nums.collect { it * 2 } //map
.findAll {it % 3 == 0 } //reduce
.sum() //reduce


List strings = 'this is a list of strings'.split()
strings.collect { it.size() } //
println strings*.size() //spread dot operator - applies method to each element in the collection
println strings.size() // applies method to the collection


def mp = [k1: 'v1', k2: 'v2', k3: 'v3']
mp.collect {k, v -> println mp[k] }

//Playing with Google's GeoCode APIs
def gmap_uri = 'http://www.google.com'
def results = gmap_uri.toURL().text
println results.size()
// println results

String base = 'https://maps.googleapis.com/maps/api/geocode/xml?'
def encoded = ['10 Fawcett Street', 'Cambridge', 'MA'].collect {
    URLEncoder.encode(it, 'UTF-8')
}.join(',')

def qs = "address=$encoded"

//"$base$qs".toURL().text
//Playing with XML results
def root = new XmlSlurper().parse("$base$qs")

def loc = root.result[0].geometry.location
println "(${loc.lat}, ${loc.lng})"

//Playing with JSON 
import groovy.json.*
String base = 'http://api.icndb.com/jokes/random?'

def qs = [limitTo: '[nerdy]', firstName:'Guillaume', lastName: 'Laforge'].collect {
    k,v -> "$k=$v"}.join('&')
    
String jsonTxt = "$base$qs".toURL().text
def json = new JsonSlurper().parseText(jsonTxt)
println json.value.joke
