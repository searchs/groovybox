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
