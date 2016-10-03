Graph [ 
	Heads: 1
	Tails: 1
	node [
 		Item: 0
 		OutDegree: 2
 		InDegree: 0
 		IsTail: false
 		IsHead: true
 		HasReflexiveEdges: false
 		Successor [
			Item: 1
			Item: 2Predecessors [
	]node [
 		Item: 1
 		OutDegree: 1
 		InDegree: 2
 		IsTail: false
 		IsHead: false
 		HasReflexiveEdges: false
 		Successor [
			Item: 3Predecessors [
			Item: 3
			Item: 0
	]node [
 		Item: 2
 		OutDegree: 2
 		InDegree: 2
 		IsTail: false
 		IsHead: false
 		HasReflexiveEdges: true
 		Successor [
			Item: 3
			Item: 2Predecessors [
			Item: 0
			Item: 2
	]node [
 		Item: 3
 		OutDegree: 2
 		InDegree: 3
 		IsTail: false
 		IsHead: false
 		HasReflexiveEdges: false
 		Successor [
			Item: 4
			Item: 1Predecessors [
			Item: 5
			Item: 1
			Item: 2
	]node [
 		Item: 4
 		OutDegree: 2
 		InDegree: 1
 		IsTail: false
 		IsHead: false
 		HasReflexiveEdges: false
 		Successor [
			Item: 5
			Item: 6Predecessors [
			Item: 3
	]node [
 		Item: 5
 		OutDegree: 1
 		InDegree: 1
 		IsTail: false
 		IsHead: false
 		HasReflexiveEdges: false
 		Successor [
			Item: 3Predecessors [
			Item: 4
	]node [
 		Item: 6
 		OutDegree: 0
 		InDegree: 1
 		IsTail: true
 		IsHead: false
 		HasReflexiveEdges: false
 		Successor [Predecessors [
			Item: 4
	]