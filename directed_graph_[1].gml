graph [
	Heads: 1
	Tails: 1
	node [
 		id 0
		label "node nr 0"
		OutDegree: "2"
		InDegree: "0"
		IsTail: "false"
		IsHead: "true"
		HasReflexiveEdges: "false"
	]
	node [
 		id 1
		label "node nr 1"
		OutDegree: "1"
		InDegree: "2"
		IsTail: "false"
		IsHead: "false"
		HasReflexiveEdges: "false"
	]
	node [
 		id 2
		label "node nr 2"
		OutDegree: "2"
		InDegree: "2"
		IsTail: "false"
		IsHead: "false"
		HasReflexiveEdges: "true"
	]
	node [
 		id 3
		label "node nr 3"
		OutDegree: "2"
		InDegree: "3"
		IsTail: "false"
		IsHead: "false"
		HasReflexiveEdges: "false"
	]
	node [
 		id 4
		label "node nr 4"
		OutDegree: "2"
		InDegree: "1"
		IsTail: "false"
		IsHead: "false"
		HasReflexiveEdges: "false"
	]
	node [
 		id 5
		label "node nr 5"
		OutDegree: "1"
		InDegree: "1"
		IsTail: "false"
		IsHead: "false"
		HasReflexiveEdges: "false"
	]
	node [
 		id 6
		label "node nr 6"
		OutDegree: "0"
		InDegree: "1"
		IsTail: "true"
		IsHead: "false"
		HasReflexiveEdges: "false"
	]
	edge [
		source 0
		target 1
		label "edge 0"
	]
	edge [
		source 0
		target 2
		label "edge 0"
	]
	edge [
		source 1
		target 3
		label "edge 1"
	]
	edge [
		source 2
		target 3
		label "edge 2"
	]
	edge [
		source 2
		target 2
		label "edge 2"
	]
	edge [
		source 3
		target 4
		label "edge 3"
	]
	edge [
		source 3
		target 1
		label "edge 3"
	]
	edge [
		source 4
		target 6
		label "edge 4"
	]
	edge [
		source 4
		target 5
		label "edge 4"
	]
	edge [
		source 5
		target 3
		label "edge 5"
	]